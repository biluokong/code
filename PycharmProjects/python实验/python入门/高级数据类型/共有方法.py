"""
共有方法：+、*、in
"""
# + 符号方法
str1 = '人生苦短,'
str2 = '我用python'
print(str1 + str2)  # 用+拼接字符串

list1 = list(range(10))
list2 = list(range(10, 20))
print(list1 + list2)  # 用+合并列表

tuple1 = tuple(range(10))
tuple2 = tuple(range(10, 20))
print(tuple1 + tuple2)  # 用+合并元组

dict1 = {'name': '张三'}
dict2 = {'age': '23'}
print(dict2)
# print(dict1 + dict2)  # 用+无法合并字典

# * 符号方法
print(str1 * 3)     # 用*复制字符串
print(list1 * 2)    # 用*复制列表
print(tuple1 * 2)   # 用*复制元组
# print(dict1 * 2)  # 用*无法复制字典

# in 判断对象是否存在的方法
print('人生' in str1)     # 用in判断指定字符串是否在目标字符串中
print(13 in list1)       # 用in判断指定数据是否在目标列表中
print(5 in tuple1)      # 用in判断指定数据是否在目标元组中
print("age" in dict1)   # 用in判断指定键是否在目标字典中(只能判断键)
