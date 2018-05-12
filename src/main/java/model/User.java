package model;


import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    @NonNull
    String id;
    String name;

    public String getName(){
        return this.name;
    }
}
