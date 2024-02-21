s = 'python'
print(type(s))
for sr in s:
    print(sr, end=" ")  # 不用end=' '，默认输出后换一行

print(s.capitalize())  # 将字符串首字符大写
a = '  d  dad    '
print(a.capitalize())
print(a.strip())  # 删除字符串左右两边的空格
print(a.lstrip())  # 删除字符串左边的空格
print(a.rstrip())  # 删除字符串右边的空格

print('a的内存地址：%d' % id(a))
b = a  # 这里只是把a的内存地址符给了b，两者指向的是同一个内存空间
print('b的内存地址：%d' % id(b))

# find()函数查找字符串，找到返回下标，每找到返回-1
# index()函数一样查找字符串，但不同之处是它没找到会报错
str1 = 'I love python'
print(s, ' ', str1)
print(str1.find(s))
print(str1.index(s))

# startswith函数判断字符串是否以参数字符串开头，是返回True，不是返回False
# endswith函数判断字符串是否以参数字符串结尾，是返回True，不是返回False
print(str1.startswith(' '))
print(str1.endswith('on'))

# lower函数将字符串转换为小写
# upper函数将字符串转换为大写
print(str1.lower())
print(str1.upper())

# 切片
print(str1[2:5])    # 输出下标为2-5（不包含5）的数据
print(str1[2:])     # 下标2和2以后的所有数据
print(str1[:3])     # 输出下标为0到3的数据（不包含3）
print(str1[::-1])   # 负号表示方向，倒序输出
print(str1[::-2])
