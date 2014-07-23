package com.dexafree.materiallistviewexample.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.dexafree.materiallistviewexample.R;
import com.dexafree.materiallistviewexample.model.BasicCard;
import com.dexafree.materiallistviewexample.model.GridItemView;

public class BasicCardItemView extends GridItemView<BasicCard> {

    TextView mTitle;

    ImageView mImage;

    TextView mDescription;

    public BasicCardItemView(Context context) {
        super(context);
    }

    public BasicCardItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BasicCardItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(mImage != null) {
            LayoutParams params = (LayoutParams) mImage.getLayoutParams();
            params.height = getMeasuredWidth();
            mImage.setLayoutParams(params);
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }


    @Override
    public void configureView(BasicCard card) {
        setTitle(card.getTitle());
        setDescription(card.getDescription());
        setImage(card.getBitmap());
    }

    public void setTitle(String title){
        mTitle = (TextView)findViewById(R.id.titleTextView);
        mTitle.setText(title);
    }

    public void setDescription(String description){
        mDescription = (TextView)findViewById(R.id.descriptionTextView);
        mDescription.setText(description);
    }

    public void setImage(Bitmap bm){
        mImage = (ImageView)findViewById(R.id.imageView);
        mImage.setImageBitmap(bm);
    }
}
