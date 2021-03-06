package com.github.travisp101.minimalistadapter.recyclerview

import android.support.v7.util.DiffUtil

interface DiffCalculator<in T> {
    fun calculateDiff(oldList: List<T>, newList: List<T>): DiffUtil.DiffResult
}

class SimpleDiffCalculator<in T>(var detectMoves: Boolean = true) : DiffCalculator<T> {
    override fun calculateDiff(oldList: List<T>, newList: List<T>): DiffUtil.DiffResult =
            DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun areItemsTheSame(oldIndex: Int, newIndex: Int): Boolean =
                        oldList[oldIndex] === newList[newIndex]

                override fun getOldListSize(): Int = oldList.size

                override fun getNewListSize(): Int = newList.size

                override fun areContentsTheSame(oldIndex: Int, newIndex: Int): Boolean =
                        oldList[oldIndex] == newList[newIndex]

            }, detectMoves)
}
