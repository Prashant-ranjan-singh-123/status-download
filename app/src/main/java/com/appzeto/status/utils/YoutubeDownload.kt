import android.app.Activity
import android.os.Environment
import android.widget.Toast
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object YoutubeDownload {

    private val DOWNLOAD_DIRECTORY = File(
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
        ""
    ).path

    @JvmStatic
    fun startDownload(videoUrl: String, activity: Activity) {
        val client = OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        val request = Request.Builder()
            .url(videoUrl)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                activity.runOnUiThread {
                    Toast.makeText(activity, "Failed to fetch video information", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (!response.isSuccessful) {
                    onFailure(call, IOException("Unexpected code $response"))
                    return
                }

                val videoFileName = "youtube_video.mp4"
                val videoFile = File(DOWNLOAD_DIRECTORY, videoFileName)

                var fos: FileOutputStream? = null
                try {
                    fos = FileOutputStream(videoFile)
                    fos.write(response.body!!.bytes())

                    activity.runOnUiThread {
                        Toast.makeText(activity, "Video downloaded successfully", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: IOException) {
                    e.printStackTrace()
                } finally {
                    fos?.close()
                }
            }
        })
    }
}
