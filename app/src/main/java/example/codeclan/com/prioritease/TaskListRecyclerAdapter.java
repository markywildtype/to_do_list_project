package example.codeclan.com.prioritease;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 28/01/2018.
 */

class TaskListRecyclerAdapter extends RecyclerView.Adapter<TaskListRecyclerAdapter.ViewHolder> {

    public TaskListRecyclerAdapter(ArrayList<Task> dummyTasks) {
        this.dummyTasks = dummyTasks;
    }

    //placeholder data
    ArrayList<Task> dummyTasks;
    //end placeholder data

    @Override
    public TaskListRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_task_list_item, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TaskListRecyclerAdapter.ViewHolder holder, int position) {
        holder.taskName.setText(dummyTasks.get(position).getTaskName());
        holder.taskCompletionStatus.setText(dummyTasks.get(position).getCompletionStatus().name());
        holder.taskPriority.setText(dummyTasks.get(position).getTaskPriority().name());
    }

    @Override
    public int getItemCount() {
        return dummyTasks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView taskName;
        public TextView taskCompletionStatus;
        public TextView taskPriority;

        public ViewHolder(View itemView) {
            super(itemView);
            taskName = itemView.findViewById(R.id.list_item_task_name);
            taskCompletionStatus = itemView.findViewById(R.id.list_item_task_completion_status);
            taskPriority = itemView.findViewById(R.id.list_item_priority);
        }
    }
}
