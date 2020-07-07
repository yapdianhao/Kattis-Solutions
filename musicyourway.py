def main():
    categories = input().split(" ")
    d = dict()
    for i in range(len(categories)):
        d[categories[i]] = i
    songs_num = int(input())
    songs = []
    for i in range(songs_num):
        song = input().split(" ")
        songs.append(song)
    queries_num = int(input())
    queries = []
    for i in range(queries_num):
        queries.append(input())
    for i in range(queries_num):
        print(" ".join(categories))
        songs.sort(key = lambda x: x[d[queries[i]]])
        for song in songs:
            print(" ".join(song))
        print("\n")

main()