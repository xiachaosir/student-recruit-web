package com.student.recruit.thread;

/**
 * Created by xiachao on 2017/4/17.
 */
public class ProduceResumeThread {

  private static final Integer MAX_COUNT = 100;

  private Integer product = 0;

  public static void main(String[] args) {

  }


  public synchronized void produce () {
    if (this.product >MAX_COUNT ) {

    }
  }
}
