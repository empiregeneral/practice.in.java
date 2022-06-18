def WordSearch():
    n, m = tuple([int(x) for x in input().strip().split(" ")])
    s = input().strip()
    arr = []
    for i in range(n):
        arr.append(input().strip())

    def loc_surroundings(loc):
        loc_up = (loc[0] - 1, loc[1])
        loc_right = (loc[0], loc[1] + 1)
        loc_below = (loc[0] + 1, loc[1])
        loc_left = (loc[0], loc[1] - 1)
        surroundings = []
        for location in [loc_up, loc_right, loc_below, loc_left]:
            if 0 <= location[0] <= n - 1 and 0 <= location[1] <= m - 1:
                surroundings.append(location)
        return surroundings

    def search_path(start_loc, s_index, tmp_result, result):
        if s_index > len(s) - 2:
            result.append(tmp_result[:])
            return
        for surround_loc in loc_surroundings(start_loc):
            if surround_loc != start_loc and surround_loc not in tmp_result and \
                    arr[surround_loc[0]][surround_loc[1]] == s[s_index + 1]:
                tmp_result.append(surround_loc)
                search_path(surround_loc, s_index + 1, tmp_result, result)
                tmp_result.pop()

    tmp_result, result = [], []
    for i in range(m):
        for j in range(n):
            if arr[i][j] == s[0]:
                tmp_result.append((i, j))
                search_path((i, j), 0, tmp_result, result)
                if result:
                    return i + 1, j + 1


if __name__ == "__main__":
    print(WordSearch())