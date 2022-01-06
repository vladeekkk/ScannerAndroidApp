package com.hedgehog.scanner.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.hedgehog.scanner.R
import com.hedgehog.scanner.domain.AppModel

class AppsRecyclerAdapter(
    private val context: Context,
    private val list: List<AppModel>,
    ) : RecyclerView.Adapter<AppsRecyclerAdapter.AppsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppsViewHolder {
        return AppsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.app_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: AppsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class AppsViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        private val name: TextView = itemView.findViewById(R.id.tv)
        private val image: ImageView = itemView.findViewById(R.id.image)

        fun bind(model: AppModel) {
            image.setImageDrawable(model.drawable)
            val size = pxFromDp(context, IMAGE_SIZE_DP).toInt()
            image.updateLayoutParams<ConstraintLayout.LayoutParams> {
                width = size
                height = size
                startToStart = R.id.constraintContainer
                topToTop = R.id.constraintContainer
                endToEnd = R.id.constraintContainer
                topMargin = pxFromDp(context, IMAGE_MARGIN_TOP).toInt()
            }
            name.text = model.appName
            name.updateLayoutParams<ConstraintLayout.LayoutParams> {
                startToStart = R.id.constraintContainer
                topToBottom = R.id.image
                endToEnd = R.id.constraintContainer
                topMargin = pxFromDp(context, TEXT_MARGIN_TOP).toInt()
            }
        }
    }

    fun pxFromDp(context: Context, dp: Float): Float {
        return dp * context.resources.displayMetrics.density
    }

    companion object {
        private const val IMAGE_SIZE_DP = 46f
        private const val IMAGE_MARGIN_TOP = 33f
        private const val TEXT_MARGIN_TOP = 16f
    }
}