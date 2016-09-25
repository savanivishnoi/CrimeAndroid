package test.com.crime;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.List;

/**
 * Created by savani on 9/15/16.
 */
public class CrimeListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
List<Crime> crimes;
   CrimeListAdapter(List<Crime> c){
     crimes = c;

   }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == 1) {
            CrimesViewHolder cvh = (CrimesViewHolder)holder;
            cvh.mTitleField.setText(crimes.get(position).getTitle());
            cvh.mSolved.setChecked(crimes.get(position).isSolved());

       }
    }

    @Override
    public int getItemCount() {
        return crimes.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 1){
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_crime, parent, false);
            return new CrimesViewHolder(v);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position, List<Object> payloads) {
      //  super.onBindViewHolder(holder, position, payloads);
        if (holder.getItemViewType() == 1) {
            CrimesViewHolder cvh = (CrimesViewHolder)holder;
            cvh.mTitleField.setText(crimes.get(position).getTitle());
            cvh.mSolved.setChecked(crimes.get(position).isSolved());
            cvh.setCrime(crimes.get(position));

        }

    }
    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }
}

 class CrimesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
     protected EditText mTitleField;
     protected CheckBox mSolved;
     protected Button mDate;
     protected Crime mCrime;
    CrimesViewHolder(View itemView){
        super(itemView);
        mTitleField = (EditText) itemView.findViewById(R.id.crime_title);
        mSolved = (CheckBox) itemView.findViewById(R.id.solved);
        mDate = (Button) itemView.findViewById(R.id.date);
        itemView.setOnClickListener(this);

    }
     void setCrime(Crime c){
         mCrime = c;
     }
     @Override
     public void onClick(View v){

     }
}
