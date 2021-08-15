# 初始化
from bs4 import BeautifulSoup

# 方法一，直接打开文件
soup = BeautifulSoup(open("1.html"))
# print(soup.body.find_all("mat-row", limit=2))
# for tag in soup.body.find_all("mat-header-row"):
for tag in soup.body.find_all("mat-row"):
    a = '|'
    # for cell in tag.find_all("mat-header-cell"):
    for cell in tag.find_all("mat-cell"):
        a = a + ' '.join(str(cell.get_text()).strip().replace('\n', '').replace('\r', '').split()) + '|'
    print(a)

# # 方法二，指定数据.get_text()
# resp = ""
# soup = BeautifulSoup(resp, 'lxml')

# # soup 为 BeautifulSoup 类型对象
# print(soup.find_all("mat-row"))

soup = BeautifulSoup(open("2.html"))
# print(soup.body.find_all("mat-row", limit=2))
# for tag in soup.body.find_all("mat-header-row"):
for tag in soup.body.find_all("mat-row"):
    a = '|'
    # for cell in tag.find_all("mat-header-cell"):
    for cell in tag.find_all("mat-cell"):
        a = a + ' '.join(str(cell.get_text()).strip().replace('\n', '').replace('\r', '').split()) + '|'
    print(a)

soup = BeautifulSoup(open("3.html"))
# print(soup.body.find_all("mat-row", limit=2))
# for tag in soup.body.find_all("mat-header-row"):
for tag in soup.body.find_all("mat-row"):
    a = '|'
    # for cell in tag.find_all("mat-header-cell"):
    for cell in tag.find_all("mat-cell"):
        a = a + ' '.join(str(cell.get_text()).strip().replace('\n', '').replace('\r', '').split()) + '|'
    print(a)

soup = BeautifulSoup(open("4.html"))
# print(soup.body.find_all("mat-row", limit=2))
# for tag in soup.body.find_all("mat-header-row"):
for tag in soup.body.find_all("mat-row"):
    a = '|'
    # for cell in tag.find_all("mat-header-cell"):
    for cell in tag.find_all("mat-cell"):
        a = a + ' '.join(str(cell.get_text()).strip().replace('\n', '').replace('\r', '').split()) + '|'
    print(a)