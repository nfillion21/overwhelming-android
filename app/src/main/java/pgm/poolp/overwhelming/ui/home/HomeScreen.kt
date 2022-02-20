package pgm.poolp.overwhelming.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.rounded.Coffee
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding
import pgm.poolp.overwhelming.R
import kotlin.math.ceil

private val screens = listOf("", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "","", "", "", "", "", "", "", "", "", "", "", "", "",)

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding()
    ) {
        StaggeredVerticalGrid(
            maxColumnWidth = 64.dp,
            modifier = modifier.padding(24.dp)
        ) {
            screens.forEach { foodItem ->
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
        //color = MaterialTheme.colors.surface,
        /*
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
         */
        //elevation = OwlTheme.elevations.card,
        shape = MaterialTheme.shapes.medium
    )  {
        Icon(
            painter = rememberVectorPainter(Icons.Rounded.Coffee),
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
