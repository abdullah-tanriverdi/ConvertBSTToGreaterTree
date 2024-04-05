// Solution sınıfı
class Solution {
    // Toplam değeri tutacak değişken
    int sumOfValues = 0;

    // BST'yi dolaşarak her düğümün değerini güncelleyen metot
    public TreeNode convertBST(TreeNode root) {
        // Dolaşma metodu çağrılıyor
        traversal(root);
        // Güncellenmiş ağaç kök düğümü ile birlikte döndürülüyor
        return root;
    }

    // DFS pre-order tarzında ağacı dolaşan metot
    private void traversal(TreeNode node) {
        // Geçerli düğüm null ise işlem sonlanır
        if (node == null)
            return;

        // Sağ alt ağaca doğru dolaşma
        traversal(node.right);

        // Düğüm değerini geçici bir değişkene kopyala
        int temp = node.val;
        // Düğüm değerine, sağ alt ağaçtaki tüm değerlerin toplamı eklenir
        node.val += sumOfValues;
        // Toplam değeri güncellenmiş düğüm değeri ile artır
        sumOfValues += temp;

        // Sol alt ağaca doğru dolaşma
        traversal(node.left);
    }

    // Çözümü test etmek için ana metod
    public static void main(String[] args) {
        // Örnek ağaç oluşturma
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(8);
        root.right.left=new TreeNode(9);
        root.right.right = new TreeNode(10);
        root.right.right.left = new TreeNode(12);
        root.right.right.left.left= new TreeNode(13);
        root.right.right.right=new TreeNode(15);

        // Solution sınıfı örneği oluşturma
        Solution solution = new Solution();

        // Dönüşümü uygulama
        TreeNode convertedTree = solution.convertBST(root);

        // Dönüştürülmüş ağacı yazdırma
        printTree(convertedTree);
    }

    // Ağacı düzgün bir şekilde yazdırmak için yardımcı metot
    public static void printTree(TreeNode root) {
        if (root == null)
            return;

        // Sol alt ağacı yazdır
        printTree(root.left);

        // Kök düğüm değerini yazdır
        System.out.print(root.val + " ");

        // Sağ alt ağacı yazdır
        printTree(root.right);
    }
}

// TreeNode sınıfı tanımı
class TreeNode {
    // Düğüm değeri
    int val;
    // Sol ve sağ çocuk düğümler
    TreeNode left;
    TreeNode right;

    // Düğüm yapıcısı
    TreeNode(int val) {
        this.val = val;
    }

    // Düğüm yapıcısı (sol ve sağ çocukları ile birlikte)
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
