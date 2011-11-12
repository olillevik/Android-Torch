package no.app.torch;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;

public class TorchActivity extends Activity {
	private Camera camera;
	private Camera.Parameters param;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	protected void onPause() {
		turnOfFlashlight();
		super.onPause();
	}

	@Override
	protected void onResume() {
		turnOnFlashlight();
		super.onResume();
	}

	private void turnOnFlashlight() {
		camera = Camera.open();
		param = camera.getParameters();
		param.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(param);
	}

	private void turnOfFlashlight() {
		param = camera.getParameters();
		param.setFlashMode(Parameters.FLASH_MODE_OFF);
		camera.setParameters(param);
		camera.release();
	}
}