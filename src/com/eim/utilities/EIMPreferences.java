package com.eim.utilities;

import com.eim.R;
import com.eim.facedetection.FaceDetector;
import com.eim.facerecognition.EIMFaceRecognizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class EIMPreferences {
	private static EIMPreferences instance;

	private SharedPreferences mSharedPreferences;

	public static EIMPreferences getInstance(Context mContext) {
		if (instance == null)
			instance = new EIMPreferences(mContext.getApplicationContext());

		return instance;
	}

	private EIMPreferences(Context mContext) {
		mSharedPreferences = PreferenceManager
				.getDefaultSharedPreferences(mContext);

		getKeysAndDefaultValues(mContext);
	}

	private String detectionScaleFactorKey;
	private String detectionScaleFactorDefault;

	public double detectionScaleFactor() {
		return Double.parseDouble(mSharedPreferences.getString(
				detectionScaleFactorKey, detectionScaleFactorDefault));
	}

	private String detectionMinNeighborsKey;
	private String detectionMinNeighborsDefault;

	public int detectionMinNeighbors() {
		return Integer.parseInt(mSharedPreferences.getString(
				detectionMinNeighborsKey, detectionMinNeighborsDefault));
	}

	private String detectionMinRelativeFaceSizeKey;
	private String detectionMinRelativeFaceSizeDefault;

	public double detectionMinRelativeFaceSize() {
		return Double.parseDouble(mSharedPreferences.getString(
				detectionMinRelativeFaceSizeKey,
				detectionMinRelativeFaceSizeDefault));
	}

	private String detectionMaxRelativeFaceSizeKey;
	private String detectionMaxRelativeFaceSizeDefault;

	public double detectionMaxRelativeFaceSize() {
		return Double.parseDouble(mSharedPreferences.getString(
				detectionMaxRelativeFaceSizeKey,
				detectionMaxRelativeFaceSizeDefault));
	}

	private String numberOfGalleryColumnsLandscapeKey;
	private String numberOfGalleryColumnsLandscapeDefault;

	public int numberOfGalleryColumnsLandscape() {
		return Integer.parseInt(mSharedPreferences.getString(
				numberOfGalleryColumnsLandscapeKey,
				numberOfGalleryColumnsLandscapeDefault));
	}

	private String numberOfGalleryColumnsPortraitKey;
	private String numberOfGalleryColumnsPortraitDefault;

	public int numberOfGalleryColumnsPortrait() {
		return Integer.parseInt(mSharedPreferences.getString(
				numberOfGalleryColumnsPortraitKey,
				numberOfGalleryColumnsPortraitDefault));
	}

	private String detectorTypeKey;
	private String detectorTypeDefault;

	public FaceDetector.Type detectorType() {
		String mType = mSharedPreferences.getString(detectorTypeKey,
				detectorTypeDefault);
		return FaceDetector.Type.valueOf(mType);
	}

	private String detectorClassifierKey;
	private String detectorClassifierDefault;

	public FaceDetector.Classifier detectorClassifier() {
		String mClassifier = mSharedPreferences.getString(
				detectorClassifierKey, detectorClassifierDefault);
		return FaceDetector.Classifier.valueOf(mClassifier);
	}

	private String recognitionTypeKey;
	private String recognitionTypeDefault;
	private String[] recognitionTypes;

	public EIMFaceRecognizer.Type recognitionType() {
		String mType = mSharedPreferences.getString(recognitionTypeKey,
				recognitionTypeDefault);

		if (recognitionTypes[0].equals(mType))
			return EIMFaceRecognizer.Type.EIGEN;
		else if (recognitionTypes[1].equals(mType))
			return EIMFaceRecognizer.Type.FISHER;
		else
			return EIMFaceRecognizer.Type.LBPH;

	}

	private String recognitionThresholdKey;
	private String recognitionThresholdDefault;

	public int recognitionThreshold() {
		return Integer.parseInt(mSharedPreferences.getString(
				recognitionThresholdKey, recognitionThresholdDefault));
	}

	private void getKeysAndDefaultValues(Context mContext) {
		detectionScaleFactorKey = mContext
				.getString(R.string.detection_scale_factor);
		detectionScaleFactorDefault = mContext
				.getString(R.string.detection_scale_factor_default);

		detectionMinNeighborsKey = mContext
				.getString(R.string.detection_min_neighbors);
		detectionMinNeighborsDefault = mContext
				.getString(R.string.detection_min_neighbors_default);

		detectionMinRelativeFaceSizeKey = mContext
				.getString(R.string.detection_min_relative_face_size);
		detectionMinRelativeFaceSizeDefault = mContext
				.getString(R.string.detection_min_relative_face_size_default);

		detectionMaxRelativeFaceSizeKey = mContext
				.getString(R.string.detection_max_relative_face_size);
		detectionMaxRelativeFaceSizeDefault = mContext
				.getString(R.string.detection_max_relative_face_size_default);

		detectorTypeKey = mContext.getString(R.string.detection_detector_type);
		detectorTypeDefault = mContext
				.getString(R.string.detection_detector_type_default);

		detectorClassifierKey = mContext
				.getString(R.string.detection_face_classifier);
		detectorClassifierDefault = mContext
				.getString(R.string.detection_face_classifier_default);
		
		numberOfGalleryColumnsLandscapeKey = mContext
				.getString(R.string.management_number_of_gallery_columns_landscape);
		numberOfGalleryColumnsLandscapeDefault = mContext
				.getString(R.string.management_number_of_gallery_columns_landscape_default);

		numberOfGalleryColumnsPortraitKey = mContext
				.getString(R.string.management_number_of_gallery_columns_portrait);
		numberOfGalleryColumnsPortraitDefault = mContext
				.getString(R.string.management_number_of_gallery_columns_portrait_default);

		recognitionTypeKey = mContext
				.getString(R.string.recognition_recognizer_type);
		recognitionTypeDefault = mContext
				.getString(R.string.recognition_recognizer_type_default);
		recognitionTypes = mContext.getResources().getStringArray(
				R.array.recognition_recognizer_type_values);

		recognitionThresholdKey = mContext
				.getString(R.string.recognition_threshold);
		recognitionThresholdDefault = mContext
				.getString(R.string.recognition_threshold_default);
	}
}
