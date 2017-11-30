package nyc.c4q.workoutapp;


import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView; // no longer needed
import android.widget.ArrayAdapter; //  When adding the adapter during Step 2 and will use this class in the onCreateView() method
import android.app.Activity; // When adding the interface during Step 3.
import android.widget.ListView; // When adding the interface during Step 3.


/**
 * A simple {@link ListFragment} subclass.
 */
public class WorkoutListFragment extends ListFragment {

/* Step 3: Part 1 - adding the interface to decouple the fragment. This will allow the fragment and activity to talk to each other without knowing too much about the other
    This will allow the fragment to talk to any kind of activity as long as it implements the interface.
    This will allow the app to know that an item on the list fragment has been clicked (will happen at runtime) */

    static interface WorkoutListListener{   //  Add the listener to the fragment
        void itemClicked(long id);
    };
    private  WorkoutListListener listener;  //  Add the listener to the fragment


    public WorkoutListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//  Step 1: Part 1
//  Below code not needed following update from Fragment to ListFragment. I can also create new ListFragment and get the correct code.
//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
//        return textView;

//  Step 2: Add ArrayAdapter import statement above along with code from lines 35 - 46
        String[] names = new String[Workout.workouts.length];
        for(int i = 0; i < names.length; i++)   {
//          Creates a String array for the workout names
            names[i] = Workout.workouts[i].getName();
        }

//      Create an array adapter that works with a list view
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
//              Get the current context from the layout inflater
                inflater.getContext(), android.R.layout.simple_list_item_1, names);
//      Binds the array adapter to the list view - ListView is a subclass of the AdapterView class which allows a view to work with adapters
        setListAdapter(adapter);

//  Step 1: Part 2
//  Below code is only line in onCreate() method
//  Calling the superclass onCreateView() method gives you the default layout for the ListFragment
        return super.onCreateView(inflater, container, savedInstanceState);
    }

//  Step 3: Part 2 - Updating fragment lifecycle methods needed. Extensive and detailed notes on lifecylce
    @Override
    public void onAttach(Activity activity){    //  (Activity activity) callesd when the fragement gets attached to an activity
        super.onAttach(activity);
        this.listener = (WorkoutListListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id){
        if(listener != null) {
            listener.itemClicked(id);   //  Tell the listener when an item in the ListView is clicked
        }
    }

}
