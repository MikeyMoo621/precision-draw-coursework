package precisiondraw;

public class SimpleMap {

    private String[] keys = new String[50];
    private PlayerStats[] values = new PlayerStats[50];
    private int size = 0;

    public PlayerStats get(String key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public PlayerStats putIfAbsent(String key) {
        PlayerStats stats = get(key);
        if (stats != null) return stats;

        keys[size] = key;
        values[size] = new PlayerStats();
        size++;
        return values[size - 1];
    }

    public int size() {
        return size;
    }

    public String getKey(int index) {
        return keys[index];
    }

    public PlayerStats getValue(int index) {
        return values[index];
    }
}
