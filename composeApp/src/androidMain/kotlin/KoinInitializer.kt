import Data.Di.dataModule
import Domain.Di.domainModule
import Presentation.Di.presentationModule
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

actual class KoinInitializer(val context: Context) {
    actual fun init() {
        startKoin {
            androidContext(context)
            androidLogger()
            modules(dataModule, domainModule, presentationModule)
        }
    }
}