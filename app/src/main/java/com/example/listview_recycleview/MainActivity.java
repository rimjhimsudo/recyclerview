package com.example.listview_recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeoutException;
import java.util.zip.CheckedOutputStream;

public class MainActivity extends AppCompatActivity {

    ListView lvCourses;
    ArrayList<Course> courses=Course.generateNRandomteachers(100);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvCourses=findViewById(R.id.lvc_names);
        //when we use findviewbyid we search thrugh view tree
        CourseAdapter courseAdapter=new CourseAdapter();
        lvCourses.setAdapter(courseAdapter);
    }


    class CourseAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return courses.size();
        }

        @Override
        public Course getItem(int position) {
            return courses.get(position) ;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            CourseViewHolder holder;
            //content view makes your memeory and cpu efficient in us by this activity.

            if ((convertView==null)) {
                convertView = getLayoutInflater().inflate(
                        R.layout.list_item_course,
                        parent,
                        false);
                 holder = new CourseViewHolder(convertView);
                convertView.setTag(holder);
            }
            else{
                holder=(CourseViewHolder)convertView.getTag();
            }

            Course course=getItem(position);
            holder.tvname.setText(course.getName());
            holder.tvteachersname.setText(course.getTeacherName());
            holder.tvlectures.setText(String.valueOf(course.getLectures())); //mistake
            return convertView;
        }
        class CourseViewHolder{
            TextView tvname, tvteachersname, tvlectures;
            CourseViewHolder(View convertView){
                TextView tvname=convertView.findViewById(R.id.tvnames);
                TextView tvteachersname=convertView.findViewById(R.id.tvteachernames);
                TextView tvlectures=convertView.findViewById(R.id.tvlectures);

            }

        }
    }
}
