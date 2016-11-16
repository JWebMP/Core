/*
 * Copyright (C) 2016 ged_m
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package za.co.mmagon;

import com.google.inject.Singleton;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * GZips content in and out
 * @author GedMarc
 */
@Singleton
public class GZipServletFilter implements Filter
{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void destroy()
    {
    }

    /**
     * GZips data in and out for everything
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException 
     */
    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException
    {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (acceptsGZipEncoding(httpRequest))
        {
            httpResponse.addHeader("Content-Encoding", "gzip");
            GZipServletResponseWrapper gzipResponse
                    = new GZipServletResponseWrapper(httpResponse);
            chain.doFilter(request, gzipResponse);
            gzipResponse.close();
        }
        else
        {
            chain.doFilter(request, response);
        }
    }

    /**
     * Sets the accept encoding
     * @param httpRequest
     * @return 
     */
    private boolean acceptsGZipEncoding(HttpServletRequest httpRequest)
    {
        String acceptEncoding
                = httpRequest.getHeader("Accept-Encoding");

        return acceptEncoding != null
                && acceptEncoding.contains("gzip");
    }
}

/**
 * A response wrapper for servlets
 * @author GedMarc
 */
class GZipServletResponseWrapper extends HttpServletResponseWrapper
{

    private GZipServletOutputStream gzipOutputStream = null;
    private PrintWriter printWriter = null;

    public GZipServletResponseWrapper(HttpServletResponse response)
            throws IOException
    {
        super(response);
    }

    /**
     * Closes the print writer stream
     * @throws IOException 
     */
    public void close() throws IOException
    {

        //PrintWriter.close does not throw exceptions.
        //Hence no try-catch block.
        if (this.printWriter != null)
        {
            this.printWriter.close();
        }

        if (this.gzipOutputStream != null)
        {
            this.gzipOutputStream.close();
        }
    }

    /**
     * Flush OutputStream or PrintWriter
     *
     * @throws IOException
     */
    @Override
    public void flushBuffer() throws IOException
    {

        //PrintWriter.flush() does not throw exception
        if (this.printWriter != null)
        {
            this.printWriter.flush();
        }

        IOException exception1 = null;
        try
        {
            if (this.gzipOutputStream != null)
            {
                this.gzipOutputStream.flush();
            }
        }
        catch (IOException e)
        {
            exception1 = e;
        }

        IOException exception2 = null;
        try
        {
            super.flushBuffer();
        }
        catch (IOException e)
        {
            exception2 = e;
        }

        if (exception1 != null)
        {
            throw exception1;
        }
        if (exception2 != null)
        {
            throw exception2;
        }
    }

    /**
     * Returns an output stream of gzip
     * @return
     * @throws IOException 
     */
    @Override
    public ServletOutputStream getOutputStream() throws IOException
    {
        if (this.printWriter != null)
        {
            throw new IllegalStateException(
                    "PrintWriter obtained already - cannot get OutputStream");
        }
        if (this.gzipOutputStream == null)
        {
            this.gzipOutputStream = new GZipServletOutputStream(
                    getResponse().getOutputStream());
        }
        return this.gzipOutputStream;
    }

    /**
     * Writes the gzip
     * @return
     * @throws IOException 
     */
    @Override
    public PrintWriter getWriter() throws IOException
    {
        if (this.printWriter == null && this.gzipOutputStream != null)
        {
            throw new IllegalStateException(
                    "OutputStream obtained already - cannot get PrintWriter");
        }
        if (this.printWriter == null)
        {
            this.gzipOutputStream = new GZipServletOutputStream(
                    getResponse().getOutputStream());
            this.printWriter = new PrintWriter(new OutputStreamWriter(
                    this.gzipOutputStream, getResponse().getCharacterEncoding()));
        }
        return this.printWriter;
    }

    @Override
    public void setContentLength(int len)
    {
        //ignore, since content length of zipped content
        //does not match content length of unzipped content.
    }
}

class GZipServletOutputStream extends ServletOutputStream
{

    private GZIPOutputStream gzipOutputStream = null;

    public GZipServletOutputStream(OutputStream output)
            throws IOException
    {
        super();
        this.gzipOutputStream = new GZIPOutputStream(output);
    }

    @Override
    public void close() throws IOException
    {
        this.gzipOutputStream.close();
    }

    @Override
    public void flush() throws IOException
    {
        this.gzipOutputStream.flush();
    }

    @Override
    public void write(byte b[]) throws IOException
    {
        this.gzipOutputStream.write(b);
    }

    @Override
    public void write(byte b[], int off, int len) throws IOException
    {
        this.gzipOutputStream.write(b, off, len);
    }

    @Override
    public void write(int b) throws IOException
    {
        this.gzipOutputStream.write(b);
    }
}
