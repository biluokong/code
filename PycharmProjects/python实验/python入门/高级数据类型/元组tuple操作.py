# 创建元组
tuple1 = ('是的', 23, 22.3, True, [11, 12, 13])
print(type(tuple1))
print(tuple1)

# 遍历和切片
for item in tuple1:
    print(item, end=' ')
print()

print(tuple1[2:4])  # 切片
print(tuple1[::-1])  # 从右到左，-1是最右边元素的下标，让后往左下标-1
print(tuple1[::-2])

print(tuple1[-2:-1:])  # 倒着取下标为-1和-2下标的元素，从右到左时，默认最右边第一个元素的下标为-1，往左减1
print(tuple1[-4:-2:])
print('-------------------------')

# 用同个变量赋值时，开辟的内存地址不一样，列表同样，不过列表用函数修改数据是，内存地址不改变
t = ()
print(id(t))
t = (13, 5)
print(id(t))
t = (12, 5, 5)
print(id(t))

# 括号内只有一个元素时，没加逗号，解释器认为是放入数据的类型
t = (3)
print(type(t))  # 输出的是整型
t = ('df')
print(type(t))  # 输出的字符串
t = (3,)
print(type(t))  # 这样输出的才是元组类型
print('--------------------------------')

# 修改操作
# 直接修改元组中的元素，解释器报错
# tuple1[0] = 'df'
# print(tuple1)

# 修改元组中列表元素中的元素，输出的元组列表的值发生了改变。
li = [1, 3, 5]
print(li)
print(id(li))
tuple2 = (23, '33', li)
print(tuple2)
li = [1, 222]     # 此li重新开辟了一个空间，并不是tuple2中那个li列表
print(li)
print(id(li))
print(tuple2)
li.append(23)
print(li)
print(id(li))
print(tuple2)

d = [34, 53]
tuple3 = ('and', d)
print(tuple3)
d.append(12)
print(tuple3)

# t = tuple((1))  # 不能这样强转，解释器报错
# print(type(t))

tuple4 = tuple(range(10))   # 这样转换是可以的
print(tuple4)

print(tuple4.count(4))  # 统计元素出现的个数

# 还可以只用逗号创建元组，不用括号
tuple5 = 2, 3, 'dfd'
print(type(tuple5))

