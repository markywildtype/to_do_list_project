package example.codeclan.com.prioritease;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 29/01/2018.
 */

class TaskListAdapter extends ArrayAdapter<Task>{

        public TaskListAdapter(Context context, ArrayList<Task> taskList) {
        super(context, 0, taskList);
    }



    public View getView(int position, View listItemView, ViewGroup parent) {
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.activity_task_list_item, parent, false);
        }

        Task currentTask = getItem(position);



        if(currentTask.taskPriority == TaskPriority.A_IMPORTANT_URGENT){
            int impUr = Color.parseColor("#ff959c");
            listItemView.setBackgroundColor(impUr);
        } else if(currentTask.taskPriority == TaskPriority.C_UNIMPORTANT_URGENT){
            int unimpUr = Color.parseColor("#a7c7ff");
            listItemView.setBackgroundColor(unimpUr);
        } else if(currentTask.taskPriority == TaskPriority.B_IMPORTANT_NONURGENT){
            int impNon = Color.parseColor("#d1aeff");
            listItemView.setBackgroundColor(impNon);
        } else if (currentTask.taskPriority == TaskPriority.D_UNIMPORTANT_NONURGENT){
            int unimpNon = Color.parseColor("#d8ffc0");
            listItemView.setBackgroundColor(unimpNon);
        }




        TextView taskName = listItemView.findViewById(R.id.list_item_task_name);
        taskName.setText(currentTask.getTaskName());

        TextView taskPriority = listItemView.findViewById(R.id.list_item_priority);
        taskPriority.setText(currentTask.getPriorityAsString());

        TextView taskCompletionStatus = listItemView.findViewById(R.id.list_item_task_completion_status);
        taskCompletionStatus.setText(currentTask.getCompletionStatusAsString());

        listItemView.setTag(currentTask);

        return listItemView;
    }
}
