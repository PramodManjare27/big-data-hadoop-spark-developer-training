package org.simplilearn;


import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable> {

    /*
        c [1,1,1]
     */
    @Override
    protected void reduce(Text key,
                          Iterable<IntWritable> values,
                          Reducer<Text, IntWritable, Text, IntWritable>.Context context) throws IOException, InterruptedException {
        int total = 0;
        for (IntWritable val : values) {
            total = total + val.get();
        }
        context.write(key, new IntWritable(total));
    }
}
