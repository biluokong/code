import os  # 引入文件操作模块


def findFile(file_Path):
    listRs = os.listdir(file_Path)  # 得到该路径下的所有文件夹
    for fileItem in listRs:
        full_Path = os.path.join(file_Path, fileItem)  # 获取完整的文件路径
        if os.path.isdir(full_Path):  # 判断是否是文件夹
            findFile(full_Path)  # 如果是一个文件夹，再次去递归
        else:
            print(fileItem)
            pass
        pass
    else:
        return
    pass


# 调用函数搜索文件
findFile('D:\\Documents')
