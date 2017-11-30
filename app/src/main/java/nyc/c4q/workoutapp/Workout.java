package nyc.c4q.workoutapp;

/**
 * Created by MsNehisi on 11/28/17.
 */

// The below data will be used by the fragment WorkoutDetailFragment - which will be created after this class.

public class Workout {
    // Each workout has a name and description. This is the standard format
    private String name;
    private String description;

    // workouts is an array of (4) Workouts - The format reflects the above with a workout name followed by the description
    //  There will be errors if there are spaces between the "\" and "n"
    public static final Workout[] workouts = {
            new Workout("The Limb Loosener", "5 Handstand push-ups\n10 1-legged squats\n15 Pull-ups"),
            new Workout("Core Agony","100 Pull-ups\n100 Push-ups\n100 Sit-ups\n100 Squats"),
            new Workout("The Wimp Special", "5 Pull-ups\n10 Push-ups\n15 Squats"),
            new Workout("Strength and Length", "500 meter run\n21 x 1.5 pound kettlebell swing\n21 x pull-ups")
    };
    //  This constructor contains the parameters for the Workout - name and description
    // The above (4) workouts have errors on them until the below constructor is added then everything works
    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //  Create the getters for the above private variables
    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    //  The String representation for a Workout is its name
    public String toString(){
        return this.name;
    }
}
