"""
面试题 16.25. LRU 缓存
设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。

它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

示例:

LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // 返回  1
cache.put(3, 3);    // 该操作会使得密钥 2 作废
cache.get(2);       // 返回 -1 (未找到)
cache.put(4, 4);    // 该操作会使得密钥 1 作废
cache.get(1);       // 返回 -1 (未找到)
cache.get(3);       // 返回  3
cache.get(4);       // 返回  4
"""


import collections
class LRUCache(collections.OrderedDict):
    """
    OrderedDict写法
    # 执行用时： 176 ms  , 在所有 Python3 提交中击败了 56.31% 的用户
    # 内存消耗： 23.3 MB , 在所有 Python3 提交中击败了 95.03% 的用户
    """
    '''
    function:利用collection.OrdereDict数据类型实现最近最少使用的算法
    OrdereDict有个特殊的方法popitem(Last=False)时则实现队列，弹出最先插入的元素
    而当Last=True则实现堆栈方法，弹出的是最近插入的那个元素。
    实现了两个方法：get(key)取出键中对应的值，若没有返回-1
    set(key,value)更具LRU特性添加元素
    '''
    def __init__(self,size=5):
        self.size = size
        self.cache = collections.OrderedDict()#有序字典
 
    def get(self,key):
        if key in self.cache.keys():
            value = self.cache.pop(key)
            self.cache[key] = value
            return value
        else:
            return -1

    def put(self,key,value):
        if key in self.cache.keys():
            self.cache.pop(key)
            self.cache[key] = value
        elif self.size == len(self.cache):
            self.cache.popitem(last=False)
            self.cache[key] = value
        else:
            self.cache[key] = value


# class LRUCache:
#     """
#     直接写法
#     # 执行用时： 396 ms  , 在所有 Python3 提交中击败了 14.52% 的用户
#     # 内存消耗： 23.3 MB , 在所有 Python3 提交中击败了 65.73% 的用户
#     """
#     def __init__(self, capacity: int):
#         self.cache ={}
#         self.used_list=[]
#         self.capacity = capacity


#     def get(self, key: int) -> int:
#         if key in self.cache:
#             if key != self.used_list[-1]:
#                 self.used_list.remove(key)
#                 self.used_list.append(key)
#             return self.cache[key]
#         else:
#             return -1

#     def put(self, key: int, value: int) -> None:
#         if key in self.cache:
#             self.used_list.remove(key)
#         elif len(self.cache) == self.capacity:
#             self.cache.pop(self.used_list.pop(0))
#         self.used_list.append(key)
#         self.cache[key] = value



# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)