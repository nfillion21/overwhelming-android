package pgm.poolp.overwhelming.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.asLiveData
import com.google.accompanist.insets.statusBarsPadding
import pgm.poolp.overwhelming.R
import pgm.poolp.overwhelming.viewmodels.FoodViewModel
import kotlin.math.ceil

@Composable
fun HomeScreen(
    viewModel: FoodViewModel,
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
            .fillMaxSize()
    ) {
        StaggeredVerticalGrid(
            maxColumnWidth = 64.dp,
            modifier = modifier
                .padding(24.dp)
                //.weight(1f)
        ) {
            val k by viewModel.foodOccurrences.collectAsState(initial = 0)
            for (i in k downTo 1)
            {
                FoodItem()
            }
        }
    }
}

@Composable
fun FoodItem(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium
    )  {

        val imageVector:ImageVector = when ((0..7).random()) {
            0 -> Icons.Rounded.LocalPizza
            1 -> Icons.Rounded.Cake
            2 -> Icons.Rounded.LunchDining
            3 -> Icons.Rounded.Coffee
            4 -> Icons.Rounded.BakeryDining
            5 -> Icons.Rounded.Icecream
            6 -> Icons.Rounded.BreakfastDining
            7 -> Icons.Rounded.EmojiFoodBeverage
            else -> {Icons.Rounded.Coffee}
        }

        Icon(
            painter = rememberVectorPainter(imageVector),
            contentDescription = stringResource(id = R.string.content_description),
            tint = MaterialTheme.colors.onPrimary,
            modifier = Modifier.background(MaterialTheme.colors.primary)
                //.size(32.dp)
        )
    }
}


@Composable
fun StaggeredVerticalGrid(
    modifier: Modifier = Modifier,
    maxColumnWidth: Dp,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier
    ) { measurables, constraints ->
        check(constraints.hasBoundedWidth) {
            "Unbounded width not supported"
        }
        val columns = ceil(constraints.maxWidth / maxColumnWidth.toPx()).toInt()
        val columnWidth = constraints.maxWidth / columns
        val itemConstraints = constraints.copy(maxWidth = columnWidth)
        val colHeights = IntArray(columns) { 0 } // track each column's height
        val placeables = measurables.map { measurable ->
            val column = shortestColumn(colHeights)
            val placeable = measurable.measure(itemConstraints)
            colHeights[column] += placeable.height
            placeable
        }

        val height = colHeights.maxOrNull()?.coerceIn(constraints.minHeight, constraints.maxHeight)
            ?: constraints.minHeight
        layout(
            width = constraints.maxWidth,
            height = height
        ) {
            val colY = IntArray(columns) { 0 }
            placeables.forEach { placeable ->
                val column = shortestColumn(colY)
                placeable.place(
                    x = columnWidth * column,
                    y = colY[column]
                )
                colY[column] += placeable.height
            }
        }
    }
}

private fun shortestColumn(colHeights: IntArray): Int {
    var minHeight = Int.MAX_VALUE
    var column = 0
    colHeights.forEachIndexed { index, height ->
        if (height < minHeight) {
            minHeight = height
            column = index
        }
    }
    return column
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SortChip(
    text: String,
    selected: Boolean,
    setSelected: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.small,
) {
    Surface(
        modifier = modifier.height(28.dp),
        color = MaterialTheme.colors.secondary,
        shape = shape,
        elevation = 2.dp
    ) {
        Box(
            modifier = Modifier.toggleable(
                value = selected,
                onValueChange = setSelected,
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(
                    horizontal = 8.dp,
                    vertical = 6.dp
                )
            ) {
                AnimatedVisibility(visible = selected) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        modifier = Modifier.width(24.dp),
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }

                Text(
                    text = text,
                    style = MaterialTheme.typography.caption,
                    maxLines = 1,

                    )
            }
        }
    }
}
