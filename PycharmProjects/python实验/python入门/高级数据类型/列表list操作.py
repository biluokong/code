li = [1, 2, 3, '你好']

print(len(li))  # len函数可以获取到序列对象中的数据个数
print(type(li))

str1 = '我喜欢python'
print(len(str1))

list1 = ['abcd', 234, 23.44, True]
print(list1)  # 输出完整的列表

# 切片
print(list1[1:3])   # 获取下标为1和2的数据
print(list1[2:])    # 获取下标为2和之后的数据
print(list1[::-1])  # 从右到左遍历

# 多次输出
print(list1*3)

print('_________________________________________')
# 常用的函数
# 增操作
list1.append('回忆')  # 追加的函数
list1.append(li)    # 列表追加列表
print(list1)

list1.insert(1, 'yyds')    # 插入数据的函数，可以插入到指定下标位置
print(list1)
rsDate = range(10)
print(rsDate)
rsDate = list(rsDate)
print(rsDate)

list1.extend(rsDate)    # 拓展列表，相当于批量添加
list1.extend([1, '我'])
print(list1)
print('------------------------------------')

# 改操作
list1[0] = '我的天'    # 根据下标修改数据
print(list1)
print('------------------------------------')

# 删除操作
print(rsDate)
rsDate.remove(2)    # 移除指定的元素
print(rsDate)

del rsDate[0]   # 删除指定下标的元素
print(rsDate)

del rsDate[1:3]  # 通过切片删除指定范围下标的元素，批量删除
print(rsDate)

rsDate.pop(0)   # 移除指定下标的元素
print(rsDate)
print('------------------------------------------')

# 查找操作
print(rsDate.index(7))  # 查找指定元素，返回它的下标；没找到，报错
