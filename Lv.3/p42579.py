def get_best_album(genre_array, play_array):
    n = len(genre_array)
    genre_total_play_dict = {}  # {"classic" : 1450, "pop" : 3100}
    genre_index_play_dict = {}  # {"classic" : [(index, play), (2, 150)], "pop" : [...]}

    for i in range(n):
        genre = genre_array[i]  # pop
        play = play_array[i]  # 500

        if genre in genre_total_play_dict:
            genre_total_play_dict[genre] += play
            genre_index_play_dict[genre].append([i, play])
        else:
            genre_total_play_dict[genre] = play
            genre_index_play_dict[genre] = [[i, play]]

    sorted_genre_total = sorted(genre_total_play_dict.items(), key=lambda item: item[1], reverse=True)
    result = []

    # sorted_genre_total 순대로 sorted_genre_index에서 최대 두개의 index를 뽑아 result에 넣어줌
    for genre, total in sorted_genre_total:
        sorted_genre_index = sorted(genre_index_play_dict[genre], key=lambda item: item[1], reverse=True)

        count = 0
        for index, play in sorted_genre_index:
            if count >= 2:
                break
            result.append(index)
            count += 1

    return result


print("정답 = [4, 1, 3, 0] / 현재 풀이 값 = ", get_best_album(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))
print("정답 = [0, 6, 5, 2, 4, 1] / 현재 풀이 값 = ", get_best_album(["hiphop", "classic", "pop", "classic", "classic", "pop", "hiphop"], [2000, 500, 600, 150, 800, 2500, 2000]))
print("정답 = [1, 3, 0] / 현재 풀이 값 = ", get_best_album(["classic", "pop", "classic", "classic"], [500, 2500, 150, 800]))

"""
 1. 장르별 총 재생횟수를 가지는 dict 만들기
    dict = {"classic" : 1450, "pop" : 3100}
 2. 장르별 각각의 재생 수를 가지는 linkedlist dict으로 만들기
    dict = {"classic" : [(0, 500), (2, 150), (3, 800)], "pop" : [(1, 600), (4, 2500)]}
"""

"""
sudo 코드

n = len(genre_array)
genre_total_play_dict = []

for i in range(n):
    genre = genre_array[i] # pop
    play = play_array[i]   # 500
    
    if genre in genre_total_play_dict:
        genre_total_play_dict[genre] += play
    else:
        genre_total_play_dict[genre] = play
"""
