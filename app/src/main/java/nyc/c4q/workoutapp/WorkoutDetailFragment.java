package nyc.c4q.workoutapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView; // This is added since this class is used in the onStart() method

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */

//  All fragments must subclass
public class WorkoutDetailFragment extends Fragment {
/*  Following the addition of the fragment to the activity_main.xml, the below code is added as an update.
    This is the ID of the workout that the user choosed. It will later be used to set the values of the fragment's views with the workout details. */
    private long workoutID;

/*  All fragments must have a public no-argument constructor. This is because Android uses it to reinstantiate
        the fragment when needed, and if its not there, a runtime exception will occur. */
    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

//  This is the onCreateView() method. Its called when Android needs the fragment's layout.
//  This method is optional but will need to be implemented whenever creating a fragment with a layout
//  This is the fragment equivalent of an activity's setContentView() method - the container argument is passed by the activity that uses the fragment.
//  Its the ViewGroup in the activity that the fragment layout needs to be inserted into.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment - Tells Android which layout the fragment uses
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

/*  This is added after the MainActivity reference for the workout id. Wasnt functional so the below update is needed.
    The getView() method gets the fragments's root View then use this to get references to the workout title and description textviews. */
    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if (view != null) {
            TextView title = (TextView) view.findViewById(R.id.textTitle);
            Workout workout = Workout.workouts[(int) workoutID];
            title.setText(workout.getName());
            TextView description = (TextView) view.findViewById(R.id.textDescription);
            description.setText(workout.getDescription());
        }
    }

/*  Following the addition of the fragment to the activity_main.xml, the below code is added as an update.
    This is a setter method for the workout ID. The activity will use this method to set the value of the workout ID. */
    public void setWorkout(long id) {
        this.workoutID = id;
    }

/*  Now the activity can call the fragment's setWorkout() method and pass it the ID of a particular workout */
}
