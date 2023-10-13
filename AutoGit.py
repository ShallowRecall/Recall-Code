import os
from datetime import datetime

# 获取当前日期和时间，并将其格式化为 YYYY-MM-DD HH:mm:ss 的形式
now = datetime.now()
formatted_datetime = now.strftime("%Y-%m-%d %H:%M:%S")

# 第一步: 执行git add .
os.system("git add .")

# 第二步: 执行git commit -m "commit message"
os.system(f'git commit -m "{formatted_datetime}"')

# 第三步: 执行git push
os.system("git push")

# 输出完成信息
print("Script completed.")
