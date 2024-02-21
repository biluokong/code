"""
输出：
%是占位符号，%后面跟变量的类型；占位符号的数量必须与%()括号内数据的个数对应
这样写能格式化输出，节省代码量；
格式化输出的另外一种方式.format()，此时的占位符为{}；这时不需要指明类型了。
格式：print(f'xxx{表达式}xxx') 这种方式仅支持python3.6以后的版本
"""

print('输出：')
name = '张三'
classroom = '高三02班'
print('%格式化：')
print('我的名字是%s，%s' % (name, classroom))
print('我的名字是%s' % name)
print('.format()格式化：')
print('我的名字是{}，{}'.format(name, classroom))

'''
输入：
用input方法来获取键盘输入：
input方法获得的输入结果都是str类型的，如果要得到需要的类型，需要转换
'''

print("input输入：")
name = input("请输入您的姓名：")
print("name的类型：", type(name))
age = input('请输入您的年龄：')
print("age的类型：", type(age))
print("您的的姓名为：", name, '您的年龄为', age)
print("您的的姓名为：{}，您的年龄为：{}".format(name, age))   # 此方法解释器不报错
# print("您的的姓名为：%s，您的年龄为：%d" % (name, age))   # 此写法解释器报错，类型需要转换

age = int(age)  # 或者 age = int(input('请输入您的年龄：'))
print("age的类型：", type(age))
print("您的的姓名为：%s，您的年龄为：%d" % (name, age))   # 此时这样写就不报错了

