package ch.zhaw.facerecognition.Activities;

/**
 * Created by Bin on 2017-11-29.
 */

// classification
import  smile.classification.SVM;
import smile.math.kernel.GaussianKernel;
import org.opencv.core.Mat;

// For reading the file
import java.util.ArrayList;
import java.util.List;
//import java.nio.file.*;

public class SVMClassifier {
    /**
     *  Reading the file  into labels  and features
     *  Generate a SVM model with  a gaussianKernel with ( Kernel and  soft marginal and label marginal
     *  In Model Class of One VS ALL
     *  and learn and predict
     * @return
     */
    double[][] srcData;
    int[] label;
    SVM < double[] > svm;
    boolean trained;




    public SVMClassifier(){
        /**
         * @param Matrix of images ? or a file
          */

    }


    public void SetSrcData(ArrayList<Mat> mats){
//        for (Mat m : mats) {
//            srcData.
//        }
        srcData = new double[mats.size()][mats.get(0).cols()*mats.get(0).rows() ];
        label = new  int [mats.size()];
        for ( int i =0 ; i < mats.size() ; i++ ) {
            double[] tmp =  new double[mats.get(i).cols()*mats.get(i).rows()] ;
            mats.get(i).get(0 ,0 ,tmp);
            for ( int j =0 ; j < tmp.length ; i++ ) {
                srcData[ i ][ j ] = tmp[ j ];
            }
            label[ i ] = i< 3 ? 1 : 2;
        }
    }

    public boolean train(){
        /**
         * train the model
         */
//        this.getClass().getResourceAsStream("processedImage1_1.png");
        if( !trained) {
            GaussianKernel  tmp =new GaussianKernel( 1.0);
            svm = new SVM<double[] >  (tmp, 1.0 , 3 , SVM.Multiclass.ONE_VS_ALL);
            svm.learn(srcData, label);
            svm.finish(); //call the reprocess until converges
        }

        return true;

    }


    public void  generate_label( ){
        /**
         * Reading the data from the matrix
         *  Loading into two collection of  lest and label
         */

    }



}
