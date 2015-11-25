# JDK 1.7 API Collections Framework

* The collections framework is a unified architecture for representing and manipulating***[mə'nɪpjulet]*** collections
 - 集合框架是一個統一的描述和操作集合的架構,
 
* enabling them to be manipulated independently of the details of their representation.
 - 使得他們能夠被獨立操作 他們所描述的細節.

* It reduces programming effort while increasing performance.
 - 他降低編程工作力當越來越多的執行性能.
 
* It enables interoperability among unrelated APIs, 
 - 他使得無關的API相互操作成為可能,

* reduces effort in designing and learning new APIs, 
 - 降低設計和學習新API的精力,

* and fosters software reuse. 
 - 促進軟體的複用.
 
* The framework is based on more than a dozen collection interfaces.
 - 這個框架以多餘十二個集合的接口為基礎. 

* It includes implementations of these interfaces and algorithms to manipulate them.
 - 他包含了一些接口的實現和算法來操作他們. 

# Collections Framework Overview

```
Introduction
```

* The Java platform includes a collections framework. 
 - JAVA平台包含一個集合框架.
* A collection is an object that represents a group of objects (such as the classic Vector class). 
 - 集合是一個描述一組實例（例如類型Vector類）的一個實體.
* A collections framework is a unified architecture for representing and manipulating collections, 
 - 集合框架是一個描述和操作集合的統一架構,
* enabling collections to be manipulated independently of implementation details. 
 - 使得集合被不依賴實現細節的操作成為可能.
 
The primary advantages of a collections framework are that it:<br>
集合框架最主要的特點如下:

  - **Reduces programming effort** by providing data structures and algorithms so you don't have to write them yourself.
    - **降低程式開發精力** 以數據結構和算法為條件以至於你無需自己編寫他們.  
  - **Increases performance** by providing high-performance implementations of data structures and algorithms. 
    - **提高性能** 以高性能的數據結構和算法實現為條件.<br>
      Because the various implementations of each interface are interchangeable,<br> 
      因為每一個接口多樣的實現是可交換的, <br>
      programs can be tuned by switching implementations.<br>
      程序能夠備調整由可轉換的實現.       
  - **Provides interoperability between unrelated APIs** by establishing***[ɪˈstæblɪʃ]*** a common language to pass collections back and forth.
    - **提供無關API之間的相互操作** 建立一個通用的可環繞操作集合的語言  
  - **Reduces the effort required to learn APIs** by requiring you to learn multiple ad hoc collection APIs.
    - **降低必要學習API的精力** 必須使得你不得不學習多種特定的集合API  
  - **Reduces the effort required to design and implement APIs** by not requiring you to produce ad hoc collections APIs.
    - **降低必須設計和實現API的精力** 是你不必要產出特定集合API  
  - **Fosters software reuse** by providing a standard interface for collections and algorithms with which to manipulate them.
    - **促進軟體的複用** 為集合提供一個基本的接口和操作他們的算法

The collections framework consists of:<br>
集合框架包含:

  - **Collection interfaces.** Represent different types of collections, such as sets, lists, and maps. 
    - **集合接口.** 描述不同的集合類型,如sets,lists,與maps<br>
      These interfaces form the basis of the framework.<br>
      這些接口表單基於框架.<br>
  - **General-purpose implementations.** Primary implementations of the collection interfaces.
    - **通用實現.** 主要的集合接口實現
  - **Legacy implementations.** The collection classes from earlier releases, Vector and Hashtable, were retrofitted to implement the collection interfaces.
    - **遺留實現.** 早期的releases版本的集合類,Vector,Hashtable被重新實現了集合接口.
  - **Special-purpose implementations.** Implementations designed for use in special situations. 
    - **特定實現.** 被設計的實現用於特定的狀況.<br>
      These implementations display nonstandard performance characteristics, usage restrictions, or behavior.<br>
      這些實現展示了非標準的執行字符,使用限制或行為.
  - **Concurrent implementations.** Implementations designed for highly concurrent use.
    - **並發的實現.** 實現被設計應用於高並發.
  - **Wrapper implementations.** Add functionality, such as synchronization, to other implementations.
    - **包裝的實現.** 為其他實現添加功能,例如synchronization.
  - **Convenience implementations.** High-performance "mini-implementations" of the collection interfaces.
    - **便捷的實現.** 高性能的集合接口的“小實現”.
  - **Abstract implementations.** Partial implementations of the collection interfaces to facilitate custom implementations.
    - **抽象的實現.** 局部的集合的實現促進定制的實現.
  - **Algorithms.** Static methods that perform useful functions on collections, such as sorting a list.
    - **算法.** 在集合中存在靜態的對平台有用的方法,例如排序的list.
  - **Infrastructure.** Interfaces that provide essential support for the collection interfaces.
    - **底層** 接口針對於集合接口的私有的必要支持.
  - **Array Utilities.** Utility functions for arrays of primitive types and reference objects. 
    - **數組工具** 針對於原始類型的數組和引用實體的工具方法.<br>
      Not, strictly speaking, a part of the collections framework, <br>
      哦,不，嚴格的來說,集合框架的一部分,<br>
      this feature was added to the Java platform at the same time as the collections framework and relies on some of the same infrastructure.<br>
      

