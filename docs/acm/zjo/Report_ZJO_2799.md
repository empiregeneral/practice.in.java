# ZJO 2799 Solved Report

## Subject
原题地址：[ZJO 2799](https://zoj.pintia.cn/problem-sets/91827364500/problems/91827366298)

这道题是一道好题，是一道其展现的算法理论和实际应用结合比较密切的题目。

题目大意是求取用尽可能少的轨距，组合成多列火车进行展览，题意可参照中国铁道博物馆的图片就一目了然了。



![几种不同的轨距，以右侧为准，左侧铁轨自左向右依次为准轨、米轨和云南鸡街一条旧铁路的600毫米窄轨。](C:\Users\canzuo\Desktop\Different_gauges_in_China_Railway_Museum.jpg)

<!--几种不同的轨距，以右侧为准，左侧铁轨自左向右依次为准轨、米轨和云南鸡街一条旧铁路的600毫米窄轨。拍摄于[中国铁道博物馆](https://zh.wikipedia.org/wiki/中国铁道博物馆)-->

## 解题思路
1. 使用差分约束系统来求解该题，难点在于输入数据有向图的建模，目前这个想了半天都想不出来怎么将输入数据建立成有向图的关系。

2. 使用回溯算法计算，根据官网的提示算法复杂度在O(2^n*(n!)^2)

   回溯算法的主要代码:说实话理解起来比较困难^-^

   ```
   static void backtrack( int act , int n, int [] l, int [] left, int [] right, int rails) throws Exception {
   		if( act == n ) {
   			// position of the rails
   			int [] tmp = new int[rails];
   			int oo = 1000000;
   			// initialize to undefined
   			for( int i = 0; i < rails; i++ )
   				tmp[i] = oo;
   			// one rail gets position 0
   			tmp[0] = 0;
   			for( int i = 0; i < n; i++ ) {
   				int cnt = 0;
   				for( int j = 0; j < n; j++ ) {
   					// if both rails of a gauge have a position, check that the distance is correct
   					if( tmp[left[j]] != oo && tmp[right[j]] != oo ) {
   						if( tmp[right[j]] != tmp[left[j]] +l[j] ) return;
   						cnt++;
   					}
   					// if the left position is known, assign the right position
   					else if( tmp[left[j]] != oo ) {
   						tmp[right[j]] = tmp[left[j]] + l[j];
   						cnt++;
   					}
   					// if the right position is known, assign the left position
   					else if( tmp[right[j]] != oo ) {
   						tmp[left[j]] = tmp[right[j]] - l[j];
   						cnt++;
   					}
   				}
   				// all gauges have been found
   				if( cnt == n ) {
   					solution = tmp;
   					throw new Exception("done");
   				}
   			}
   			return;
   		}
   		// first, assign gauges to rails without assigning any position to the rails
   		for( int j = 0; j < rails; j++ )
   			for( int k = j+1; k < rails ;k++ ) {
   				left[act] = j;
   				right[act] = k;
   				backtrack( act+1, n, l, left, right, rails);
   			}
   	}
   ```

   

## 经验总结

## Hit Problems

差分约束系统相关

POJ-1716 POJ-1201 POJ-2983

回溯算法相关