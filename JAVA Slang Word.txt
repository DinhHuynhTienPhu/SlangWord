Báo cáo project slangword
1. Thông tin sinh viên
   1. Họ tên: Đinh Huỳnh Tiến Phú
   2. MSSV: 19120325
2. Thông tin về project:
Link youtube: https://youtu.be/5GN7-ZjmH8A
   3. Mô tả chung
* Đây là project slangword. Một ứng dụng chạy trên console có chức năng giúp người dùng tra cứu các slangword và ý nghĩa của chúng cũng như ngược lại. Ngoài ra còn một số tính năng vui khác như word of the day, quiz.
* Project được lập trình bằng ngôn ngữ java. Sử dụng IDE là VSCODE
   1. Các tính năng đã làm được:
1. Chức năng tìm kiếm theo slang word.
        Tự đánh giá: 10/10
2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.
        Tự đánh giá: 10/10
3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
        Tự đánh giá: 10/10
4. Chức năng add 1 slang words mới.
        Tự đánh giá: 10/10
5. Chức năng edit 1 slang word.
        Tự đánh giá: 10/10
6. Chức năng delete 1 slang word. Confirm trước khi xoá.
        Tự đánh giá: 10/10
7. Chức năng reset danh sách slang words gốc.
        Tự đánh giá: 10/10
8. Chức năng random 1 slang word (On this day slang word).
        Tự đánh giá: 10/10
9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.
        Tự đánh giá: 10/10
10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.
        Tự đánh giá: 10/10
Tổng điểm tự đánh giá: 100/100
   2. References:
                        Sử dụng Levenshtein.java (github.com) (trong phần chức năng 1,2 để tìm kiếm tương tự)
                        Sử dụng github AI copilot extension để code nhanh hơn


   3. Cấu trúc dữ liệu sử dụng
  

* Class sử dụng chính là class SlangWord. Trong đó có chứa HashMap slangMap dùng để lưu dữ liệu theo dạng key - pair.
* Class Pair có 2 biến dữ liệu quan trọng là word và meaning. Ngoài ra còn các biến khác hỗ trợ cho việc tìm kiếm bằng levenshtein.
* Class Levenshtein có hàm duy nhất là trả về Levenshtein giữa 2 string.