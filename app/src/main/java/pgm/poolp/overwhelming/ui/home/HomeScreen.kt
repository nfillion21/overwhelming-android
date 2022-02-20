package pgm.poolp.overwhelming.ui.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.statusBarsPadding

@Composable
fun HomeScreen(
    modifier: Modifier
) {
    Column(modifier = modifier.statusBarsPadding()) {

        LazyColumn() {
        }
    }
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
