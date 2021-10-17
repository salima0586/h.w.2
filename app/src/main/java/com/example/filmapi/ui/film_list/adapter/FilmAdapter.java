package com.example.filmapi.ui.film_list.adapter;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.filmapi.data.Films;
import com.example.filmapi.databinding.ItemListBinding;
import java.util.ArrayList;
import java.util.List;

public
class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    List<Films> list = new ArrayList<>();
    private Callback callback;
    private SaveToRoom saveToRoom;
    private
    ItemListBinding binding;

    public FilmAdapter(Callback callback,SaveToRoom saveToRoom){
        this.callback = callback;
        this.saveToRoom = saveToRoom;
    }

    public FilmAdapter(){}

    @Override
    public
    ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemListBinding.inflate( LayoutInflater.from( parent.getContext() ) );
        return new ViewHolder( binding,callback,saveToRoom);
    }

    @Override
    public
    void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.onBind(list.get( position ));
    }

    @Override
    public
    int getItemCount() {
        return list.size();
    }

    public void addItems(List<Films>films){
        list.addAll( films );
        notifyDataSetChanged();
    }

    public
    class ViewHolder extends RecyclerView.ViewHolder {

        private ItemListBinding binding;
        private Callback callback;
        private SaveToRoom saveToRoom;

        public
        ViewHolder(@NonNull ItemListBinding itemView,Callback callback,SaveToRoom saveToRoom) {
            super( itemView.getRoot() );
            this.callback = callback;
            this.saveToRoom = saveToRoom;
            this.binding = itemView;
        }

        public
        void onBind(Films films) {
            binding.textTitleFilm.setText( films.getTitle() );
            binding.textDirectorFilm.setText( films.getProducer() );
            binding.imageSaveToRoom.setOnClickListener( v->saveToRoom.click( films ) );
            binding.textTitleFilm.setOnClickListener( v-> callback.filmClick( films ) );
        }
    }
    public interface Callback{
        void filmClick(Films films);
    }
    public interface SaveToRoom{
        void click(Films films);
    }
}
