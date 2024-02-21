"""
字典dict是python中重要的一种数据类型，可以储存任意对象。
字典是以键值对的形式储存的：利用{’key‘:’value‘}这种方式创建

字典中找某个元素时，是根据键访问

访问值的安全方式是get方法，在我们不确定字典中是否有某个键又想获取其值时，可以使用get方法，还可以设置默认值

字典支持增删改和统计操作

特点：
        ●不是序列类型，没有下标的概念，是一个无序的键值集合，是内置的高级数据类型。
        ●用{}表示字典对象，每个键值用逗号隔开
        ●每个键必定是唯一的，若存在重复的键，则后者会覆盖前者。

注意：
        ●它的键key不能重复，value值可以重复
        ●字典的键key只能是不可变类型，如数字、字符串、元组，value值可以是如何类型
"""
# 创建字典。只要没重新赋值，只是添加键值对，其地址一样
dict1 = {}  # 空字典
print(id(dict1))
# 添加方式
dict1['name'] = '张三'
print(id(dict1))
print(dict1)
dict1['age'] = 30
print(dict1)
# 赋值操作
dict1 = {'name': '李四'}
print(id(dict1))
print(dict1)

# 获得长度，一个键值对为一项
dict2 = {'name': '王五', 'age': 30, 'job': '搬砖'}
print(dict2)
print(len(dict2))

# 通过键查找值，没有找到相应的值，则会报错。
print(dict2['name'])
# print(dict1['yyds']) 报错

# 修改键对应的值。update函数既可以修改，也可以添加
dict2['name'] = '光头强'  # 用下标修改
print(dict2['name'])
dict2.update({'age': 22})  # 用update函数修改
dict2.update({'height': 179})  # 用update函数还可以添加数据
print(dict2)

# 获取所有的键
print(dict2.keys())

# 获取所有的值
print(dict2.values())

# 获取所有的数据项，即键值对
print(dict2.items())  # 用函数
for item in dict2.items():  # 通过迭代
    print(item)

# for key, value in dict2.items():
#     print(key + '==' + value)   # 报错，因为有整型数据
for key, value in dict2.items():
    print('%s==%s' % (key, value))

# 删除, 可以通过del 和pop函数删除
del dict2['name']
print(dict2)
dict2.pop('age')
print(dict2)

print(type(dict2.items()))

# 对字典进行排序，可以按照key或value来排序。
dict3 = {'name': '哆啦梦', 'age': 123, 'job': '睡觉', 'type': '狸猫'}
print(sorted(dict3.items(), key=lambda d: d[0]))    # d[0]代表key，这是按照key排序
# print(sorted(dict3.items(), key=lambda d: d[1]))    # d[1]代表value，这是按照value排序，报错，因为类型不一致

