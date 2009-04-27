import opencv.OpenCV;
import cxcore.CxcoreLibrary.CvSize;
import cxcore.CxcoreLibrary.IplImage;
import highgui.HighguiLibrary;
import highgui.HighguiLibrary.CvArr;
import highgui.HighguiLibrary.CvCapture;

import static cv.CvLibrary.*;
import static highgui.HighguiLibrary.*;

import com.sun.jna.*;
import com.sun.jna.ptr.*;

// Also read : http://opencv.willowgarage.com/wiki/Mac_OS_X_OpenCV_Port
/*
java -jar ../../Prog/Java/bin/jnaerator.jar @opencv.jnaerator
javac -cp ../../Prog/Java/bin/jnaerator.jar:cv.jar:. Test.java
java -cp ../../Prog/Java/bin/jnaerator.jar:cv.jar:. Test /Users/ochafik/Pictures/Dessins/download.png 

*/
public class OpenCVTest extends OpenCV {
	public static void main(String[] args) {
		try {
			IplImage src = highgui.cvLoadImage(args[0], CV_LOAD_IMAGE_UNCHANGED);
			System.out.printf("Image: width = %d, height = %d, depth = %d, channels = %d", src.width, src.height, src.depth, src.nChannels);
			
			int outDepth = 32;
				//src.depth;
			
			CvSize.ByValue s = new CvSize.ByValue();
			s.width = src.width;
			s.height = src.height;
			
			IplImage dest = cxcore.cvCreateImage(s, outDepth, src.nChannels);
			
			cv.cvSmooth(arr(src), arr(src), CV_GAUSSIAN, 23, 5, 0, 0);
//			cv.cvSmooth(arr(src), arr(dest), CV_GAUSSIAN, 13, 0, 0, 0);
			cv.cvLaplace(arr(src), arr(dest), 3);
			
			CvCapture cameraCapture = highgui.cvCreateCameraCapture(-1);
			int cvGrabFrame = highgui.cvGrabFrame(cameraCapture);
			IplImage image = highgui.cvRetrieveFrame(cameraCapture);
			if (image != null)
				highgui.cvSaveImage("camera.png", new CvArr(image.getPointer()));
			
			String out = args[0]+ ".out.png";
			highgui.cvSaveImage(out, new CvArr(dest.getPointer()));
			
			Runtime.getRuntime().exec(new String[] {Platform.isMac() ? "open" : "start",  out});
			
			
//			highgui.cvNamedWindow("Output", CV_WINDOW_AUTOSIZE);
//			highgui.cvShowImage("Output", new HighguiLibrary.CvArr(dest.getPointer()));
			
			cxcore.cvReleaseImage(new PointerByReference(src.getPointer()));
			cxcore.cvReleaseImage(new PointerByReference(dest.getPointer()));

//			highgui.cvDestroyWindow("Output");
		} catch (Throwable th) {
			th.printStackTrace();
		}
	}

	private static CvArr arr(IplImage img) {
		return new CvArr(img.getPointer());
	}
}
