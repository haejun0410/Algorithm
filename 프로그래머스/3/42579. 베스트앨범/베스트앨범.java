import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genrePlayMap = new HashMap<>();
        HashMap<String, List<Integer>> genreMusicMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            genrePlayMap.put(genres[i], genrePlayMap.getOrDefault(genres[i], 0) + plays[i]);
            genreMusicMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }


        List<String> sortedGenres = new ArrayList<>(genrePlayMap.keySet());
        sortedGenres.sort((a, b) -> genrePlayMap.get(b) - genrePlayMap.get(a));

        List<Integer> result = new ArrayList<>();

        for (String genre : sortedGenres) {
            List<Integer> musicList = genreMusicMap.get(genre);

            musicList.sort((a, b) -> {
                if (plays[b] != plays[a]) return plays[b] - plays[a];
                return a - b;
            });

            result.add(musicList.get(0));
            if (musicList.size() > 1) {
                result.add(musicList.get(1));
            }
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}
