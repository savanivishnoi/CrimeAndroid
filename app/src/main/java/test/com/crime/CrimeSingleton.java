package test.com.crime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by savani on 9/14/16.
 */
public class CrimeSingleton {
    public static CrimeSingleton mInstance;
    private List<Crime> crimesList;
    private CrimeSingleton(){
        crimesList = new ArrayList<>();

       for(int i = 0 ; i< 10; i++){
           Crime c = new Crime();
           c.setTitle("Crime # "+i);

           if( i%2 == 0){
              c.setSolved(true);
           }
           crimesList.add(c);
       }

    }
    public static CrimeSingleton getInstance(){
        if(mInstance == null){
            mInstance = new CrimeSingleton();
        }
        return mInstance;
    }
    public List<Crime> getCrimes(){
        return crimesList;
    }
    public Crime getCrime(UUID id){
        for(Crime crime: crimesList){
            if( crime.getUid()== id){
                return crime;
            }
        }
        return null;
    }

}
