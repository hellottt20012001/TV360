package com.mtkcardbookvr.tv360;

import android.os.Bundle;
import android.view.OrientationEventListener;

import com.cardbookvr.renderbox.IRenderBox;
import com.cardbookvr.renderbox.RenderBox;
import com.cardbookvr.renderbox.Transform;
import com.cardbookvr.renderbox.components.Camera;
import com.cardbookvr.renderbox.components.Sphere;
import com.google.vrtoolkit.cardboard.CardboardActivity;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.mtkcardbookvr.tv360.RenderBoxExt.components.Plane;
import com.mtkcardbookvr.tv360.RenderBoxExt.materials.BorderMaterial;

public class MainActivity extends CardboardActivity implements IRenderBox {

    CardboardView cardboardView;
    final int DEFAULT_BACKGROUND = R.drawable.bg;
    Sphere photosphere;
    Plane screen;
    OrientationEventListener orientationEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardboardView = (CardboardView) findViewById(R.id.cardboard_view);
        cardboardView.setRenderer(new RenderBox(this, this));
        setCardboardView(cardboardView);
    }

    @Override
    public void setup() {
        setupBackground();
        setupScreen();
    }

    void setupBackground() {
        photosphere = new Sphere(DEFAULT_BACKGROUND, false);
        new Transform()
                .setLocalScale(Camera.Z_FAR * 0.99f, -Camera.Z_FAR * 0.99f, Camera.Z_FAR * 0.99f)
                .addComponent(photosphere);
    }

    void setupScreen() {
        Transform screenRoot = new Transform()
                .setLocalScale(4, 4, 1)
                .setLocalRotation(0, -90, 0)
                .setLocalPosition(-5, 0, 0);

        screen = new Plane();
               BorderMaterial screenMaterial = new BorderMaterial();
        screen.setupBorderMaterial(screenMaterial);

        new Transform()
                .setParent(screenRoot, false)
                .addComponent(screen);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        orientationEventListener.disable();
    }

    @Override
    public void preDraw() {

    }

    @Override
    public void postDraw() {

    }

}
