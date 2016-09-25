package test.com.crime;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.zip.Inflater;

/**
 * Created by savani on 9/14/16.
 */
public class CrimeFragment extends Fragment {
    private static final String TAG = "Crime fragment";
    Crime mCrime;
    EditText mTitleField;
    private static final String ARG_CRIME_ID = "crime_id";


    public static CrimeFragment getInstance(UUID id){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID,id );
        CrimeFragment crimeFragment = new CrimeFragment();
        crimeFragment.setArguments(args);
        return crimeFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on create");
        UUID id  =(UUID) getArguments().getSerializable(ARG_CRIME_ID);
        mCrime = CrimeSingleton.getInstance().getCrime(id);
        mTitleField.setText(mCrime.getTitle());


       // FragmentManager fm = getF


       // ArrayList<EditText> et = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ){
        Log.d(TAG, "before v");
        View v = inflater.inflate(R.layout.fragment_crime, container, false);
        Log.d(TAG, "after v");
        mTitleField =(EditText) v.findViewById(R.id.crime_title);
        mTitleField.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {
                Log.d(TAG, "before text changed "+charSequence + "  start "+start+" count "+count+" after "+after);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                Log.d(TAG, "on text changed "+charSequence + "  start "+start+" count "+count+" before "+before);
                mCrime.setTitle(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {
             Log.d(TAG, editable+ "  textchanged");
            }
        });
        return v;


    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "on start");
        CrimeSingleton.getInstance().getCrimes().add(new Crime());
        List<Crime> crimes = new ArrayList<>();
               crimes.addAll(CrimeSingleton.getInstance().getCrimes());
        crimes.add(new Crime());
        List<Crime> newCrimes = CrimeSingleton.getInstance().getCrimes();


    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "on resume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "on pause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "on stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"on destroy");
    }
}
