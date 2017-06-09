package com.jack.slidereler;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import android.view.TextureView;

import java.io.IOException;

/**
 * Edit date 2017/5/23
 * Author:lifei
 * Description:
 */
public class CameraPreview extends TextureView implements TextureView.SurfaceTextureListener {
    private Camera mCamera;
    private TextureView mTextureView;

    public CameraPreview(Context context, Camera mCamera) {
        super(context);
        this.mCamera = mCamera;
    }

    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i1) {
        mCamera = Camera.open();
        try {
            mCamera.setPreviewTexture(surfaceTexture);
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
            Log.v(CameraPreview.class.toString(), "onSurfaceTextureAvailable_Error");
        }

    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i1) {

    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        mCamera.stopPreview();
        mCamera.release();
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        if (isAvailable()) {
            getSurfaceTexture();
        }
        Bitmap bmp = mTextureView.getBitmap();
        int width = bmp.getWidth();
        int height = bmp.getHeight();
        int[] pixels = new int[bmp.getHeight() * bmp.getWidth()];
        bmp.getPixels(pixels, 0, width, 0, 0, width, height);


    }
}
