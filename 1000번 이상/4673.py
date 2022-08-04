not_self_number = []
for i in range(10000):
    sum = i                         # 75
    while i != 0:
        sum += i % 10               # sum = 75 + 5    sum = 80 + 7  
        i //= 10                    # 75 // 10 = 7    7 // 10 = 0      -> i = 0   -> 탈출
    not_self_number.append(sum)

for i in range(10000):
    if i not in not_self_number:
        print(i)
        
        
        
# 다른 풀이
numbers = set(range(1, 10000))
remove_set = set()

for number in numbers:
  for char in str(number):
    number += int(char)
  remove_set.add(number)

result = numbers - remove_set
for self_num in sorted(result):
  print(self_num)
