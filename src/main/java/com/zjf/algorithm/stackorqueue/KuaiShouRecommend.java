package com.zjf.algorithm.stackorqueue;

import com.zjf.juc.disruptor.v4.Main;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description :
 * @Author : ZJF
 * @Date: 2020-10-26 23:47  //时间
 */
public class KuaiShouRecommend {

	/**
	 * 推荐结果打散:
	 * 给定一个包含视屏和图片的集合,按照给定的最大视屏数,按照最少视屏数加一个图片的方式返回集合
	 * 例如快手推荐视屏,每至少3个视屏后面可以放置一个图片
	 * {v0,v1,v2,p3,p4,p5,v6,p7,v8,v9} ,最少视屏数为3
	 * 返回: {v0,v1,v2,p3,v6,v7,v8,p4,v9}
	 */
	public List<String> getRecommendenResult(List<String> picAndVideo,int maxInterval){
		List<String> result = new ArrayList<>();
		if (picAndVideo == null || picAndVideo.size() == 0){
			return  result;
		}
		Queue<String> videoQueue = new LinkedList<String>();
		Queue<String> picQueue = new LinkedList<String>();
		Boolean firstPic = false;
		int index = 0;
		int picAndVideoSize = picAndVideo.size();
		//首先往result中放置列表前序video的数据
		while (!firstPic && index < picAndVideoSize){
			if (isVideo(picAndVideo.get(index))){
				result.add(picAndVideo.get(index));
				index++;
			}else{
				firstPic = true;
			}
		}
		//把列表中其余元素放置到对应的队列中
		while (index < picAndVideoSize){
			if(isVideo(picAndVideo.get(index))){
				videoQueue.add(picAndVideo.get(index));
			}else {
				picQueue.add(picAndVideo.get(index));
			}
			index++;
		}
		//两个队列按照最大视屏数按序放置到result
		int currentSize = result.size();
		while (!videoQueue.isEmpty() && !picQueue.isEmpty()){
			if (currentSize >= maxInterval){
				result.add(picQueue.poll());
				currentSize = 0;
			} else {
				result.add(videoQueue.poll());
				currentSize ++;
			}
		}
		//判断视屏队列中是否还有数据
		while (!videoQueue.isEmpty()){
			result.add(videoQueue.poll());
		}
		//判断图片队列是否还有数据且还没有超过最大视屏数,此情况只能放置一个图片数
		if (!picQueue.isEmpty() && currentSize >= maxInterval){
			result.add(picQueue.poll());
		}
		return result;
	}

	private boolean isVideo(String s) {
		if (s.indexOf('v') != -1){
			return true;
		}
		return  false;
	}

	public static void main(String[] args) {
		List<String> picAndVideoList = new ArrayList<>();
		picAndVideoList.add("v0");
		picAndVideoList.add("v1");
		picAndVideoList.add("v2");
		picAndVideoList.add("p3");
		picAndVideoList.add("p4");
		picAndVideoList.add("p5");
		picAndVideoList.add("v6");
		picAndVideoList.add("p7");
		picAndVideoList.add("v8");
		picAndVideoList.add("v9");
		List<String> result = new KuaiShouRecommend().getRecommendenResult(picAndVideoList,
				3);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));

		}
	}
}
