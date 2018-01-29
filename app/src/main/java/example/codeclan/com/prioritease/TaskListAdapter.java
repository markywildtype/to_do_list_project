package example.codeclan.com.prioritease;

import android.content.Context;
import android.support.annotation.NonNull;
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

        TextView taskName = listItemView.findViewById(R.id.list_item_task_name);
        taskName.setText(currentTask.getTaskName());

        TextView taskPriority = listItemView.findViewById(R.id.list_item_priority);
        taskPriority.setText(currentTask.getPriorityAsString());

        TextView taskCompletionStatus = listItemView.findViewById(R.id.list_item_task_completion_status);
        taskCompletionStatus.setText(currentTask.getCompletionStatusString());

        listItemView.setTag(currentTask);

        return listItemView;
    }
}
