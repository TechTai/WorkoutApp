package nyc.c4q.workoutapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener{
//  Step 2 - Part 1 -  update activity to implement the interface

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//  Step 1
/*  Before an activity can talk to its fragment, the activity first needs to get a reference to it.
    To get a reference to the fragment, first there must be a reference to the activity's fragment manager
    using the activity's getFragmentManager() method. Then use its findFragmentById() method to get a
    reference to the actual fragment. */

//  Step 2 - Part 2 - Remove the below code on lines 22 and 27 as no longer hardcoding which workout to display. Update with itemClicked() method

//  This gets the reference to the WorkoutDetailFragment as its id is in the activity's layout as detail_frag
//        WorkoutDetailFragment frag = (WorkoutDetailFragment) getFragmentManager().findFragmentById(R.id.detail_frag);

        /*Error message: "Inconvertible types; cannot cast "android.app.Fragment" to "nyc.c4q.workoutapp.WorkoutDetailFragment"
        The only way to correct the error was to change the import statement from "android.support.v4.app.fragment" to "android.app.Fragment" */

//  This will get the WorkoutDetailFragment to display details of a workout to check if its working
//        frag.setWorkout(1);

     @Override
     public void itemClicked(long id){
         /* The code used to set the details. This method is defined in the listener.
            To update the workout details, I will replace the detail fragment with a brand-new detail fragment, each time I want its text to change.
            This will allow the fragment to work with the back button and be returened to the first workout chosen */
        }
    }
}
