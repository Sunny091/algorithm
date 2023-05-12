public class HW07_4110056028_3 extends LLK {
    class Entry {
        final double slope;
        final Entry next;

        public Entry(final double slope, final Entry next) {
            this.slope = slope;
            this.next = next;
        }
    }

    final byte log_num = 5;
    final Entry[][] Hash = new Entry[1 << log_num][];
    final Thread[] thread = new Thread[Hash.length - 1];
    volatile boolean result;

    public boolean checkLLK(int[][] array) {
        result = false;

        final int end = array.length - 1, thread_Len = thread.length, freq = Hash.length;
        final int bNum = 1 << 32 - Integer.numberOfLeadingZeros(end), B = bNum - 1;

        for (byte ti = 0; ti < thread_Len; ++ti) {
            final byte t = ti;
            thread[t] = new Thread(() -> {
                for (int i = end - t, j, bucket; i > -1; i -= freq) {
                    for (Hash[t] = new Entry[bNum], j = i - 1; j > -1;) {
                        final double slope = (array[i][1] - array[j][1]) / (double) (array[i][0] - array[j--][0]);

                        bucket = Double.hashCode(slope) & B & 0x7fff_ffff;

                        for (Entry Pivot = Hash[t][bucket]; Pivot != null; Pivot = Pivot.next) {
                            if (Pivot.slope == slope)
                                result = true;

                            if (result)
                                return;
                        }

                        Hash[t][bucket] = new Entry(slope, Hash[t][bucket]);

                        if (result)
                            return;
                    }
                    if (result)
                        return;
                }
            });
            thread[t].setDaemon(true);
            thread[t].start();
            if (result)
                return true;
        }

        for (int i = end - thread_Len, j, bucket; i > -1; i -= freq) {
            for (Hash[thread_Len] = new Entry[bNum], j = i - 1; j > -1;) {
                final double slope = (array[i][1] - array[j][1]) / (double) (array[i][0] - array[j--][0]);
                bucket = Double.hashCode(slope) & B & 0x7fff_ffff;
                for (Entry Pivot = Hash[thread_Len][bucket]; Pivot != null; Pivot = Pivot.next)
                    if (Pivot.slope == slope || result)
                        return true;
                Hash[thread_Len][bucket] = new Entry(slope, Hash[thread_Len][bucket]);
            }
            if (result)
                return true;
        }

        try {
            for (final Thread t : thread) {
                if (result)
                    return true;
                t.join();
            }
        } catch (final InterruptedException e) {
        }
        return result;
    }

}
